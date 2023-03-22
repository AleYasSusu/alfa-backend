package ages.alfa.service;

import ages.alfa.model.IUser;

public interface UserService {

    IUser auth(final String email);
}
