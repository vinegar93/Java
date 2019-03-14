package cn.hwd.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import cn.hwd.bean.User;

public class SolrTest {

	private HttpSolrClient solrClient;
	private String url = "http://localhost:8983/solr/user";
	
    @Test
    public void insertUser() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	solrClient.addBean(new User(1, "Jerry", 2));
    	solrClient.commit();
        solrClient.close();
    }
    
    @Test
    public void insertUsers() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	List<User> users = new ArrayList<User>();
        users.add(new User(2, "Tom", 4));
        users.add(new User(3, "Diana", 3));
        solrClient.addBeans(users);
        solrClient.commit();
        solrClient.close();
    }
    
    @Test
    public void addDocument() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	//创建一个文档对象
    	SolrInputDocument doc = new SolrInputDocument();
    	//向文档中添加域
    	doc.addField("id", 4);
    	doc.addField("name", "Borny");
    	doc.addField("age", 27);
    	doc.addField("sex", "man");
    	doc.addField("tel", "10086");
    	//把document对象添加到索引库中
    	solrClient.add(doc);
    	//提交修改
    	solrClient.commit();
        solrClient.close();
    }
    
    @Test
    public void updateUser() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
        solrClient.addBean(new User(3, "Test", 3));
        solrClient.commit();
        solrClient.close();
    }
    
    @Test
    public void deleteById() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	solrClient.deleteById("4");
    	solrClient.commit();
        solrClient.close();
    }

    @Test
    public void deleteByQuery() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	solrClient.deleteByQuery("*:*");
    	solrClient.commit();
        solrClient.close();
    }
    
    @Test
    public void query() throws IOException, SolrServerException {
    	solrClient = new HttpSolrClient(url);
    	SolrQuery query = new SolrQuery();
    	//设置主查询条件
    	query.setQuery("*:*");
    	//过滤条件
        query.addFilterQuery("age:[1 TO 5]");//区间
        query.setSort("id", ORDER.asc);//排序
        query.setStart(0);//分页
        query.setRows(10);
        query.setFields("id","name","age");//显示的字段
        query.setHighlight(true);//高亮显示
        query.addHighlightField("name");//高亮显示的域
        query.setHighlightSimplePre("<em>");//高亮显示的前缀
        query.setHighlightSimplePost("</em>");//高亮显示的后缀
        QueryResponse response = solrClient.query(query);
        SolrDocumentList results = response.getResults();
        System.out.println(results.getNumFound());  
        for(SolrDocument doc:results) {
            System.out.println(doc.get("id") + "," + doc.get("name") + "," + doc.get("age")); 
        }
        solrClient.close();
    }

}
