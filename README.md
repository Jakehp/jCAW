# The Problem

Interacting with Confluence's JSON API can be a hassle.

# The Solution

jCAW, JSON-Confluence API Wrapper, enables a developer to easily and gracefully interact with any Confluence JSON API.

# Install

        go to the dist folder and download the jCAW1.3.jar. Use it as a library in your project.
        

# Example Code / Hello World


```
#!java
        //Creation & Connection Of A Service Object
        ConfluenceService myService = new ConfluenceService();
        myService.setBaseURL("https://confluenceServiceDomain.com");
        myService.setLoginToken("jprather", "qwerty");
        myService.setAPIVersion(1);
        
        myService.connect();
        
        //Building the parameters for the request
        List<Object> parameters = new LinkedList<Object>();
        parameters.add("xyz");
        
        //Uncomment one of the following
             //Request & Recieve, a List of HashMaps.
             //List<HashMap<String, String>> responseData;
             //responseData = myService.requestList("methodName", parameters);

             //Another Way To Request & Recieve, a JSONArray, Using this request method is much more stable.
             //JSONArray responseData;
             //responseData = myService.requestJArray("methodName", parameters);

        //Example / Print The Response
        if(responseData!=null){
             int z=0;
             for(z=0;z<responseData.size();++z) {
                System.out.println(responseData.get(z).toString());
             }
        }

```


# Dependencies

None! Just include the jar or source code in your project.


Status: 

* Lib Complete.

todo: 

* None - until bugs/issues are found.

