package com.kangmin.algo.stack;

public class DequeUsingThreeStacks {

    // |<s1>| 2 1 5 4 3  // initially
    // |<s2>|
    // |<s3>|

    // |<s1>|
    // |<s2>| 5 1 2
    // |<s3>| 3 4      // first half go to s3, later come back to s1

    // |<s1>| 4 3     for enque, and push/pop
    // |<s2>| 5 1 2   for deque
    // |<s3>|
}
