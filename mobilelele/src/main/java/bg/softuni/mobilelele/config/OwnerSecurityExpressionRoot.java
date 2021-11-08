package bg.softuni.mobilelele.config;


import bg.softuni.mobilelele.service.OfferService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnerSecurityExpressionRoot extends SecurityExpressionRoot implements
    MethodSecurityExpressionOperations {

  private Object filterObject;
  private Object returnObject;
  private OfferService offerService;

  /**
   * Creates a new instance
   *
   * @param authentication the {@link Authentication} to use. Cannot be null.
   */
  public OwnerSecurityExpressionRoot(
      Authentication authentication) {
    super(authentication);
  }

  @Override
  public void setFilterObject(Object filterObject) {
    this.filterObject = filterObject;
  }

  @Override
  public Object getFilterObject() {
    return filterObject;
  }

  @Override
  public void setReturnObject(Object returnObject) {
    this.returnObject = returnObject;
  }

  @Override
  public Object getReturnObject() {
    return returnObject;
  }

  @Override
  public Object getThis() {
    return this;
  }

  public boolean isOwner(Long id) {
    String userName = currentUserName();
    if (userName != null) {
      return offerService.isOwner(userName, id);
    }
    return false;
  }

  private String currentUserName() {
    Authentication auth = getAuthentication();
    if (auth.getPrincipal() instanceof UserDetails) {
      return ((UserDetails)auth.getPrincipal()).getUsername();
    }
    return null;
  }

  public OfferService getOfferService() {
    return offerService;
  }

  public OwnerSecurityExpressionRoot setOfferService(
      OfferService offerService) {
    this.offerService = offerService;
    return this;
  }
}
