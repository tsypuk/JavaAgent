javac AgentMemoryCounter.java
jar -cvfm Agent.jar  manifest.mf Agent.class
java -javaagent:Agent.jar AgentTester
