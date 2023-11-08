package niit.jdp.Auth2.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import niit.jdp.Auth2.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String, String> map = new HashMap<>();
        String jwtToken = Jwts.builder().setIssuer("myApp")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "mysecret")
                .compact();
        map.put("token", jwtToken);
        map.put("Message", "successfully logging");
        return map;
    }


}
