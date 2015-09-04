# esclient
ElasticSearch Java Client - strongly typed using Gson

# Usage

```java
// create a new client
ElasticSearchClient esClient = new HttpElasticSearchClientImpl("http://localhost:9200");

// check if an index exists or not
boolean exists = esClient.existsIndex("sangupta");

// create a new one
if(!exists) {
    // use default index settings
    IndexSettings settings = new IndexSettings();
    
    // create a new mapping for a new collection in index
    IndexMapping documents = new IndexMapping();
    
    // add fields that are part of index
	documents.addIndexField("_id", new StringField(FieldAnalysis.NotAnalyzed));
	documents.addIndexField("docID", new StringField(FieldAnalysis.NotAnalyzed));
	documents.addIndexField("caseID", new StringField());
	documents.addIndexField("link", new StringField());
	documents.addIndexField("author", new StringField());
	documents.addIndexField("title", new StringField());
	documents.addIndexField("content", new StringField());
	documents.addIndexField("updated", new DateField(DateFieldFormat.EpochMillis));
	documents.addIndexField("comments", new StringField(FieldAnalysis.NotAnalyzed));
	
	Map<String, IndexMapping> mappings = new HashMap<>();
	mappings.put("docs", documents);
	
	// create index
	esClient.createIndex("sangupta", settings, mappings);
}

// let's add an interceptor that will create a new field in index
// when the document is being indexed. It will also check via a boolean
// field INDEXED if the document is already in ElasticSearch

esClient.addDocumentIndexInterceptor(new DocumentIndexInterceptor<CustomDocument>() {
			
	@Override
	public boolean beforeSerialization(CustomDocument document) {
        if(document.isIndexed()) {
            return true; // stop indexing now
        }
        
        // go ahead and index
		return false;
	}
	
	@Override
	public boolean afterSerialization(JsonElement jsonElement) {
		JsonObject object = jsonElement.getAsJsonObject();
		if(object == null) {
			return false;
		}
		
		// remove the boolean property - no need of it
		object.remove("indexed");
		
		// add the indexing time
        object.addProperty("indexedTime", System.currentTimeMillis());
        
        // go ahead and index
		return false;
	}
	
});

// now add data to it
for(CustomDocument doc : getAllDocuments()) {
    esClient.indexDocument("sangupta", "docs", doc.getDocID(), doc);
}

// we may now search for documents
```

# Alternatives

There are two other alternatives to this library.

* [Official ElaticSearch Java Client](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)
* [Jest](https://github.com/searchbox-io/Jest)

The only drawback with both of them was that they provided a lot of flexibility and thus were not very strongly-typed. Like, 
creating an index was not straightforward.

# License

```
esclient - Strongly-typed Java client for ElasticSearch
Copyright (c) 2015, Sandeep Gupta

http://sangupta.com/projects/esclient

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
