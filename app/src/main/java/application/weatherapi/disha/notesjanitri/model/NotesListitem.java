package application.weatherapi.disha.notesjanitri.model;

public class NotesListitem {

    private boolean complete;
    private String title;

    public NotesListitem(boolean complete, String title) {
        this.complete = complete;
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
