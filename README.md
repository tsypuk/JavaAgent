# JavaAgent
Usage of org.javassist. 
Created few agents: TimeAgent, TraceAgent, MemoryAgent, ClassCounterAgent

Running javaagents:
javac AgentMemoryCounter.java
jar -cvfm Agent.jar  manifest.mf Agent.class
java -javaagent:Agent.jar AgentTester