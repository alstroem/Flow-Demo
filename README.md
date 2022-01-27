# Flow Demo

### Cold and Hot flows
Cold Flows -  Won't trigger any producer code until a terminal operator is called<br/>
Terminal operators are suspending functions that start the collection of the flow<br/>
For each new collector there will be a new Flow created

Hot Flow - Collecting from the flow doesn't trigger any producer code<br/>
A shared flow is called hot because its active instance exists independently of the presence of collectors<br/>
When a new consumer starts collecting from the flow, it receives the last state in the stream and any subsequent states<br/>

### Flow
Cold flow<br/>
Stateless - value can't be accessed through .value<br/>
Often used in Data layers<br/>

### StateFlow
Hot flow<br/>
Requires an initial state to be passed in to the constructor<br/>
Not tied to a lifecycle, and thus does not stop collecting automatically<br/>
A StateFlow is always active and in memory, and it becomes eligible for garbage collection only when there are no other references to it from a garbage collection root<br/>

### SharedFlow
Hot flow<br/>
Broadcast fashion<br/>
Replay option for new consumers<br/>
Subscription count<br/>


https://flowmarbles.com/
