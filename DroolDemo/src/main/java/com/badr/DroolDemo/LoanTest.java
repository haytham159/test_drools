package com.badr.DroolDemo;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import FakeApi.Parser;


public class LoanTest {
	
	//The id of the customer to test the loan eligibility for

	public static void main(String[] args) throws DroolsParserException, IOException {
		
		LoanTest client = new LoanTest();
		
		//////////////////////////////////////////////////////
		//Computing execution time
		/////////////////////////////////////////////////////
		 long startTime = System.nanoTime();

	        /* … The code being measured starts … */

	        // put the execute method here
		 	
	 		client.execteRule();

	        long endTime = System.nanoTime();

	        // get the difference between the two nano time valuess
	        long timeElapsed = endTime - startTime;
	        
	        System.out.println("Execution time in nanosecond: " + timeElapsed);
	        System.out.println("Execution time in seconds: " + timeElapsed / 1000000000);
		 	
	        
	        
	        ///////////////////////////////////////////////////////////////////////////////
	        /** memory check **/ 
	        // Get the Java runtime
	        Runtime runtime = Runtime.getRuntime();
	        // Run the garbage collector
	        runtime.gc();
	        // Calculate the used memory
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("Used memory is bytes: " + memory);
	        System.out.println("Used memory is megabytes: "
	                + bytesToMegabytes(memory));
        
	}
	
	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
	
	

	public void execteRule() throws DroolsParserException, IOException{
		   PackageBuilder builder = new PackageBuilder();
		   String ruleFile = "/loan.drl";
		   InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		   
		   Reader ruleReader = new InputStreamReader(resourceAsStream);
		   builder.addPackageFromDrl(ruleReader);
		   org.drools.core.rule.Package rulePackage = builder.getPackage();
		   RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		   ruleBase.addPackage(rulePackage);
		   
		   WorkingMemory workingMemory = ruleBase.newStatefulSession();
		   
		   Loan loanTest = new Loan();
		   
		   
		   ///////////////////////////////////////////////////////////////////////////
		   //Getting values from Api
		   //////////////////////////////////////////////////////////////////////////
		    Parser parser = new Parser();
	        parser.doHttpGet();
	        
	        org.json.JSONArray jsonArray = parser.getJsonArray();
	        
	        
	    	loanTest.set_id(0);
    		JSONObject project;
			try {
				project = (JSONObject)jsonArray.get(loanTest.get_id());
				loanTest.set_name((String)project.get("name"));
		    	loanTest.set_firstname((String)project.get("firstname"));
		    	loanTest.set_age((int) project.get("age"));
		    	loanTest.set_maried((String)project.get("maried"));
		    	loanTest.set_job((String)project.get("job"));
		    	loanTest.set_salary((int)project.get("salary"));
		    	loanTest.setCriminalHistory((String)project.get("criminalHistory"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	

    		
    		System.out.println("Name of the client : ");
    		System.out.println(loanTest.get_firstname() + " " + loanTest.get_name());
    		

		   workingMemory.insert(loanTest);
		   
		   //workingMemory.fireAllRules();
		   
		   for(int i=0; i<100; i++) {
			   workingMemory.fireAllRules();
		   }
		   
		   
		   
		   System.out.println("Loan acceptance is  "+loanTest.getLoanEligibility());
	       
	   } 
}