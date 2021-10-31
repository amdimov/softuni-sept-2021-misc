package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.view.StatsView;
import bg.softuni.mobilelele.service.StatsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

  private int anonymousRequests, authenticatedRequests;

  @Override
  public void increaseRequests() {
    Object principal =
        SecurityContextHolder.
            getContext().
            getAuthentication().
            getPrincipal();

    if (principal instanceof UserDetails) {
      authenticatedRequests++;
    } else {
      anonymousRequests++;
    }
  }

  @Override
  public StatsView getStats() {
    return new StatsView().
        setAnonymousRequests(anonymousRequests).
        setAuthenticatedRequests(authenticatedRequests);
  }
}
