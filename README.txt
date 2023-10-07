Jorge Patino assignment 2 10/6/23

    the compilation and running of the driver file can all be done by using the command ./compile in the main assignment directory

    the changing of the type of file can also be done by editing the compile script by simply changing the file name (choose between "int", "double", and "string".

    deleteSubsection : the complexity of this method is O(n) since there is only one while loop to go through each node within the bounds given. if there is a node with values in the reange, they are deleted.

    reverseList : the complexity of this method is O(n) since there is one loop since the nodes that are used as placeholders for positions are update in every iteration until the loop is broken.

    swapAlternate : swap alternates also only uses one loop to go through the list but only iterates n/2 times which makes it O(log n)
    the method starts by swapping the first 2 nodes and setting head to the correct node, then it moves to the next group of two unmodified nodes, then the next and backs of the nodes are updated to swap and keep a link the the rest of the unswapped list. once it reaches the end, a special case where the cpos position is null and the next and back pointers are changed without causeing null pointer exceptions
