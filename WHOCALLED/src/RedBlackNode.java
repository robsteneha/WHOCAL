 

class RedBlackNode
{
    RedBlackNode left, right;
    long element;
    int color;

    /* Constructor */
    public RedBlackNode(long theElement)
    {
        this( theElement, null, null );
    }
    
    /* Constructor */
    public RedBlackNode(long theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
    

}
