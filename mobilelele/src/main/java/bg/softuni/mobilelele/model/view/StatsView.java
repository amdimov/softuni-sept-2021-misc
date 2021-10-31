package bg.softuni.mobilelele.model.view;

public class StatsView {

  private int anonymousRequests;
  private int authenticatedRequests;

  public int getAnonymousRequests() {
    return anonymousRequests;
  }

  public StatsView setAnonymousRequests(int anonymousRequests) {
    this.anonymousRequests = anonymousRequests;
    return this;
  }

  public int getAuthenticatedRequests() {
    return authenticatedRequests;
  }

  public StatsView setAuthenticatedRequests(int authenticatedRequests) {
    this.authenticatedRequests = authenticatedRequests;
    return this;
  }

  public int getTotalRequests() {
    return getAnonymousRequests() + getAuthenticatedRequests();
  }
}
