package lk.nie.planningDepOauthService.service;


import dep.planning.core.models.AuthUserDetail;
import dep.planning.core.models.User;
import lk.nie.planningDepOauthService.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailRepository userDetailRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser=userDetailRepository.findByUsername(name);
        optionalUser.orElseThrow(()-> new UsernameNotFoundException("Incorrect User Name Or Password"));
        UserDetails userDetails =new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}