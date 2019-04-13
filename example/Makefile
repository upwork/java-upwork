# Makefile for Upwork API java example
#

SRC_PATH   = src
SRC_NAME   = TestApi
SRC        = $(SRC_PATH)/$(SRC_NAME).java
LIB_DIR    = ./../lib
CLASSPATH  = "$(LIB_DIR)/httpcomponents-client-4.3.3/httpcore-4.3.2.jar:$(LIB_DIR)/httpcomponents-client-4.3.3/httpclient-4.3.3.jar:$(LIB_DIR)/httpcomponents-client-4.3.3/commons-codec-1.6.jar:$(LIB_DIR)/httpcomponents-client-4.3.3/commons-logging-1.1.3.jar:$(LIB_DIR)/signpost-1.2.1.2/signpost-core-1.2.1.2.jar:$(LIB_DIR)/signpost-1.2.1.2/signpost-commonshttp4-1.2.1.2.jar:$(LIB_DIR)/java-json.jar:$(LIB_DIR)/java-upwork.jar:../$(SRC_PATH):./$(SRC_PATH)"

compile :
	javac -cp $(CLASSPATH) $(SRC)

run :
	java -cp $(CLASSPATH) $(SRC_NAME)
