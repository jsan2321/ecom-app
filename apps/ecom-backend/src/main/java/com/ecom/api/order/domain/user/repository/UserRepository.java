package com.ecom.api.order.domain.user.repository;

import com.ecom.api.order.domain.user.aggregate.User;
import com.ecom.api.order.domain.user.vo.UserAddressToUpdate;
import com.ecom.api.order.domain.user.vo.UserEmail;
import com.ecom.api.order.domain.user.vo.UserPublicId;

import java.util.Optional;

public interface UserRepository {

  void save(User user);

  Optional<User> get(UserPublicId userPublicId);

  Optional<User> getOneByEmail(UserEmail userEmail);

  void updateAddress(UserPublicId userPublicId, UserAddressToUpdate userAddress);

}
