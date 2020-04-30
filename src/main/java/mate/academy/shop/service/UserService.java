package mate.academy.shop.service;

import java.util.Optional;
import mate.academy.shop.model.User;

public interface UserService extends GenericService<User> {
    Optional<User> getByLogin(String login);
}
