package eu.nets.ms.pia.integration.nets.netaxept;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.test.util.ReflectionTestUtils;

public class NetAxeptConfigTest {
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private NetAxeptConfig config = new NetAxeptConfig();
	
	@Before
	public void setup() throws IOException{
		createMockSecretContent(tempFolder.newFile("secrets.properties"));
		
		ReflectionTestUtils.setField(config, "secretsPath", tempFolder.getRoot().getPath());
		ReflectionTestUtils.setField(config, "cancelUrl", "https://cancel");
		ReflectionTestUtils.setField(config, "redirectUrl", "https://redirect");
		ReflectionTestUtils.setField(config, "timeout", 2000);
		config.init();
	}
	
	@Test
	public void shouldReturnDefaultValueWhenSpecifficNotFound(){
		assertThat(config.getUserName("bogus").isEmpty(), equalTo(false));
		assertThat(config.getUserName(), not(containsString("testUser")));
	}
	
	@Test
	public void shouldReturnCorrectSectionValue(){
		assertThat(config.getUserName("merchant1"), equalTo("testUser1"));
		assertThat(config.getUserName("merchant2"), equalTo("testUser2"));
		assertThat(config.getUserName(), not(isEmptyString()));
		assertThat(config.getUserName(), not(containsString("testUser")));
		
	}
	
	private void createMockSecretContent(File file) throws IOException{
		Charset charSet = Charset.forName("US-ASCII");
		FileUtils.writeStringToFile(file, "netaxeptToken=token0\n", charSet, true);
		FileUtils.writeStringToFile(file, "netaxeptPassword=pwd0\n", charSet, true);
		FileUtils.writeStringToFile(file, "netaxeptUser=111111\n", charSet, true);
		
		FileUtils.writeStringToFile(file, "merchant1.netaxeptToken=token1\n", charSet, true);
		FileUtils.writeStringToFile(file, "merchant1.netaxeptPassword=pwd1\n", charSet, true);
		FileUtils.writeStringToFile(file, "merchant1.netaxeptUser=testUser1\n", charSet, true);
		
		FileUtils.writeStringToFile(file, "merchant2.netaxeptToken=token2\n", charSet, true);
		FileUtils.writeStringToFile(file, "merchant2.netaxeptPassword=pwd2\n", charSet, true);
		FileUtils.writeStringToFile(file, "merchant2.netaxeptUser=testUser2\n",charSet, true);
	}
}