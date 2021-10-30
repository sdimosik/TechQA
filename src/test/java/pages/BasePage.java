package pages;

public abstract class BasePage {
    public BasePage() {
        check();
    }

    protected abstract void check();

}
