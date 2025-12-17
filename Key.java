public class Key{
    String usage;
    String description;

    /**
     * Constructor for Key class
     * @param description the description of the key
     */
    public Key(String description){ 
        // coorisponding door attribute is in the door class, not sure if this will work in the long run though
        this.description = description;
    }
}