# JavaAgent
## DESRIPTION
The presentation for SoftServe java community about JVM, byte code processing and javaagents.
Usage of org.javassist. 
Created few agents: TimeAgent, TraceAgent, MemoryAgent, ClassCounterAgent
TimeAgent - stops the time on JVM
TraceAgent - show the chain of all methods invocation for instrumented class
MemoryAgent - calculates the memory of JVM
ClassCounterAgent - calculates loaded classes count

See the JavaAgent.pdf with presentation.

## HOW TO RUN
Running javaagents:
javac AgentMemoryCounter.java
jar -cvfm Agent.jar  manifest.mf Agent.class
java -javaagent:Agent.jar AgentTester
