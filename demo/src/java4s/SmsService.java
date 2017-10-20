package java4s;









import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;






public final class SmsService {


	/** SMS Account User Id */
	//private final String SMS_ACC_USER_ID = "5611";
	private final String SMS_ACC_USER_ID = "pranamconsultancy";
	
	/** SMS Account Password */
	private final String SMS_ACC_PASSWORD = "Advanced";
	
	/** SMS Account Sender Id */
	private final String SMS_ACC_SENDER_ID = "ESCAPQ";

	/** SMS URL Host */
	private final String SMS_URL_HOST = "http://www.smsjust.com/blank/sms/user/urlsms.php?";
	//private final String SMS_URL_HOST = "http://localhost:8080/api/pushsms.php?";
	
	/** SMS Sending URL Query string
	{0} - Recipients Mobile Number (multiple number can be added by separating with comma)
	{1} - Message Text  */
	private String SMS_URL_QUERY = "username="+ SMS_ACC_USER_ID +
										 "&pass="+ SMS_ACC_PASSWORD +
										 "&senderid="+ SMS_ACC_SENDER_ID+
										 "&dest_mobileno={0}&message={1}&response=Y"; 
	
	/** SMS Url */
	private final String SMS_URL = SMS_URL_HOST + SMS_URL_QUERY;
	
	/** URL Encoder for white space */
	private final String ENCODE_SPACE = "%20";
	
	/** URL Encoder for comma */
	private final String ENCODE_COMMA = "%2C";
	
	/** URL Encoder for line feed (new line) */
	private final String ENCODE_LF = "%0A";
	
	
	/**
	 * Default constructor, Don't make it public or private
	 * It should be visible only within package so keep visibility default
	 */
	SmsService(){ }
	
	/**
	 * Send sms by using sms provider
	 * 
	 * @param mobileNo mobile number to send sms
	 * @param messageText message text
	 * @param mobile 
	 * @param password 
	 * @return true if sms sent successfully, else false
	 */
	public synchronized boolean sendSms( String mobile, String  userid, String password, String msg){
		
		SMS_URL_QUERY = "username="+ userid +
				 "&pass="+ password +
				 "&senderid="+ SMS_ACC_SENDER_ID+
				 "&dest_mobileno={0}&message={1}&response=Y"; 

/** SMS Url */
 String SMS_URL = SMS_URL_HOST + SMS_URL_QUERY;

		
		boolean isSmsSent = false;		// initially sms sent is false
		
		// replace query parameters with actual mobile number and message text
		String smsUrl = SMS_URL.replace("{0}", mobile).replace("{1}", msg);
		
		// encode url by replacing space, comma and new line with corresponding encoding code
		smsUrl = smsUrl.replace(" ", ENCODE_SPACE).replace(",", ENCODE_COMMA).replace("\n", ENCODE_LF);
		
		try{
			
			URL url = new URL(smsUrl);	// get url from url string
			
			URLConnection urlConnection = url.openConnection();	// open url connection
			urlConnection.connect();	// connect to url
			
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;	// get http url connection object from url connection
			
			int responseCode = httpConnection.getResponseCode();	// get response code
         			
			if(responseCode == HttpURLConnection.HTTP_OK){	// if response code is HTTP+OK then message sent successfully 
				isSmsSent = true;
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSmsSent;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		
		StringBuffer mchinestr = new StringBuffer();
		

			String sCurrentLine;
			
			File file = new File("C:\\v/sms.txt");
			
			if(file.exists()){

			br = new BufferedReader(new FileReader("C:\\v/sms.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				
				System.out.println(sCurrentLine);
			}
			}
				
		
		SmsService s = new SmsService();
		String mobile = "";
		String userid = "";
		String password = "";
		String msg = "";
		
		//s.sendSms(mobile, userid, password, msg);
		//System.out.println("msg successfully sent");
	}
	
	
}
