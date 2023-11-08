package niit.jdp.Auth2.security;

import niit.jdp.Auth2.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String,String> generateToken(User user);
}
