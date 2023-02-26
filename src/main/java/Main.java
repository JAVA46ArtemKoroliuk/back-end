import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		
		List <DTO> dtoList=new ArrayList<>();
		Random random=new Random();
		for(int i=1; i<=50;i++) {
			DTO dto=new DTO();
			dto.userName="accounts"+i;
			dto.password=generateRandomString(8);
			LocalDateTime currentDateTime=LocalDateTime.now();
			int randomHours=random.nextInt(501)-100;
			LocalDateTime expirationDateTime=currentDateTime.plusHours(randomHours);
			dto.experation=expirationDateTime.toString();
			dto.rules=generateRandomRules();
			dtoList.add(dto);
			}
		ObjectMapper mapper=new ObjectMapper();
		try {
			mapper.writeValue(new File("accounts.json"), dtoList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
    private static String[] possibleRoles = {"ADMIN", "STATIST", "USER", "APPL_ADMIN"};

	private static String[] generateRandomRules() {
		  Random random = new Random();
	        Set<String> rolesSet = new HashSet<>();
	        int numRoles = random.nextInt(4) + 1; 
	        while (rolesSet.size() < numRoles) {
	            int randomIndex = random.nextInt(4);
	            rolesSet.add(possibleRoles[randomIndex]);
	        }
	        return rolesSet.toArray(new String[0]);
	    }
	

	private static String generateRandomString(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return builder.toString();
	}

}
