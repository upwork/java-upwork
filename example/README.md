1. Download signpost from https://code.google.com/p/oauth-signpost/downloads/list (both core and commonhttp)
2. Download HttpClient 4 from http://hc.apache.org/
3. Download org.json from http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm
4. Link external jars
   - signpost-core-VERSION.jar,
   - signpost-commonhttp-VERSION.jar 
   - httpcore-VERSION.jar,
   - httpclient-VERSION.jar,
   - commons-codec-VERSION.jar,
   - commons-logging-VERSION.jar,
   - java-json.jar
5. Finally link java-upwork.jar to your project.
6. Create upwork.properties and set up your key/secret; by default OAuthClient reads data from it.
You can also overwrite super class Config and use your own as a parameter for OAuthClient constructor, 
in that way, keys can be stored elsewhere.
7. See TestApi.java example to build a simple application that uses Upwork API.

Some steps from the above are automated already in the `Makefile`, so to run the `TestApi.java`
example app you can just use:

      make
      make run
