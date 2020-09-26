//package linkedlist;
//
//import java.util.Base64;
//import com.amazonaws.services.secretsmanager.AWSSecretsManager;
//import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
//import com.amazonaws.services.secretsmanager.model.DecryptionFailureException;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
//import com.amazonaws.services.secretsmanager.model.InternalServiceErrorException;
//import com.amazonaws.services.secretsmanager.model.InvalidParameterException;
//import com.amazonaws.services.secretsmanager.model.InvalidRequestException;
//import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
//
//public class SecreteManager {
//	
//public static void getSecret() {
//
//    String secretName = "devl-aws-secret";
//    String region = "eu-west-2";
//
//
//    System.out.println("REQUEST GOES TO SERVER");
//    AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
//                                    .withRegion(region)
//                                    .build();
//   
//
//    System.out.println("REQUEST COMPLETE TO SERVER");
//    String secret, decodedBinarySecret;
//    
//    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
//                    .withSecretId(secretName);
//    GetSecretValueResult getSecretValueResult = null;
//
//    try {
//
//        System.out.println("REQUEST FOR SECRETE VALUE TO SERVER");
//        getSecretValueResult = client.getSecretValue(getSecretValueRequest);
//    } catch (DecryptionFailureException e) {
//        throw e;
//    } catch (InternalServiceErrorException e) {
//        throw e;
//    } catch (InvalidParameterException e) {
//        throw e;
//    } catch (InvalidRequestException e) {
//        throw e;
//    } catch (ResourceNotFoundException e) {
//        throw e;
//    }
//
//    if (getSecretValueResult.getSecretString() != null) {
//        secret = getSecretValueResult.getSecretString();
//        System.out.println("ALL THE SECRETE VALUES"+secret);
//    }
//    else {
//        decodedBinarySecret = new String(Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array());
//    }
//}
//
//	public static void main(String[] args) {
//		SecreteManager.getSecret();
//		
//	}
//
//}
