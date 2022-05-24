/**
 * Office class extended from Abstract Building Class
 */
public class Office extends Building{
    private String jobType;
    private String owner;

    /**
     * Default Office Constructor.
     */
    public Office(){
        this.jobType = "NONE";
        this.owner = "NONE";
    }

    /**
     *
     * @param startPoint of Office
     * @param length of Office
     * @param height of Office
     * @param position of Office
     * @param jobType of Office
     * @param owner of Office
     */
    public Office(int startPoint, int length, int height, int position, String jobType, String owner) {
        super(startPoint, length, height, position);
        this.jobType = jobType;
        this.owner = owner;
    }

    @Override
    public void focus() {
        System.out.println("\nTHIS OFFICE'S JOB TYPE IS "+this.jobType);
    }

    /**
     * Getter for  Job Type of Office
     * @return Job Type of Office
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * Setter for Job Type of Office
     * @param jobType of office
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * Getter for owner of the Office
     * @return owner of the Office
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter for owner of the Office
     * @param owner of the Office
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}