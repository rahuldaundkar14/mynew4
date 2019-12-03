package com.testrunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.BeforeClass;
import org.junit.Test;

import com.core.utils.PropertyReader;

//import org.junit.Before;
//import org.junit.Test;


public class Runner {

	static {
		System.out.println("Hyyyyyyyyyyyy");
	}

	@Test
	public void tt() {
		System.out.println("Gooo...");
	}

	@BeforeClass
	public static void createTestRunnerFiles()
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InstantiationException, ClassNotFoundException, InvocationTargetException {
		System.out.println("Hyyyyyyyyyyyy");

		URLClassLoader classLoader = new URLClassLoader(new URL[] { new File("./").toURI().toURL() });
		File file = null;
		File[] paths;
		boolean success = false;
		int totalFiles = 0;

		try {
			// create new file
			file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\testrunner\\");
			// returns pathnames for files and directory
			paths = file.listFiles();
			totalFiles = paths.length;
			System.out.println(totalFiles + "..................");
			// for each pathname in pathname array
			for (File path : paths) {
				String filename = path.getName().split("\\.")[0];
				if (!filename.equals("Runner")) {
					// prints file and directory paths
					System.out.println(path);
					success = path.delete();

					// Load the class from the classloader by name....

					if (success) {
						System.out.println(file.getAbsoluteFile() + " Deleted");
					} else {
						System.out.println(file.getAbsoluteFile() + " Deletion failed!!!");
					}
				}
			}

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}

		PropertyReader propertyReader = new PropertyReader();
		for (int device = 0; device < 2; device++) {

			String deviceName = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_devicename");
			String devicePlatform = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_platformname");
			String devicePlatformVer = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_platformversion");
			String deviceudid = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_udid");
			String deviceAutomationName = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_automationname");
			String deviceSystemPort = propertyReader.getProperties("config")
					.getProperty("device_" + String.valueOf(device) + "_systemport");
		
			System.out.println("deviceName" + deviceName);
			System.out.println("devicePlatform" + devicePlatform);
			System.out.println("devicePlatformVer" + devicePlatformVer);
			System.out.println("deviceudid" + deviceudid);
			System.out.println("deviceAutomationName" + deviceAutomationName);
			System.out.println("deviceSystemPort" + deviceSystemPort);

			String classname = "TestDevice_" + (device+1);
			// create an empty source file
			File sourceFile = new File(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\testrunner\\" + classname + ".java");
			// sourceFile.deleteOnExit();

			// generate the source code, using the source filename as the class
			// name
			// String classname = sourceFile.getName().split("\\.")[0];

			String pkg = "package com.testrunner;";
			String impBefCls = "import org.junit.BeforeClass;";
			String cucumberRun = "import org.junit.runner.RunWith;";
			String cucumberOpt = "import cucumber.api.CucumberOptions;";
			String cucumberApi = "import cucumber.api.junit.Cucumber;";
			//String cucumberApi = "import cucumber.api.testng.AbstractTestNGCucumberTests;";
			String impDriMan = "import com.stepdefs.Steps;";

			String impFile = "import java.io.File;";
			// String impReporter = "import com.cucumber.listener.Reporter;";
			//String impAfter = "import org.junit.After;";
			
			String b = "@RunWith(Cucumber.class)";
			String c = "@CucumberOptions(";
			String f = "features = \"src/test/resources/features\"";
			String g = ",glue = {\"com.stepdefn\",\"com.hooks\"}"; //com.core.listners.ExtentCucumberAdapter:
			String p = ",plugin = {\"com.core.listners.ExtentCucumberAdapter:\"}"; //com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:
			String t = ", tags = {\"@android, @ios\"})";
			
			String sourceCode = "public class " + classname
					+ "{ public void hello() { System.out.print(\"Hello world\");}}";
			String sourceCode1 = "@BeforeClass \n public static void beforeClass() " + "{ \n "
					
					+ "}}";

			// write the source code into the source file
			FileWriter writer = new FileWriter(sourceFile);
			writer.write(pkg);
			writer.write("\n");
			writer.write(impBefCls);
			writer.write("\n");
			writer.write(cucumberRun);
			writer.write("\n");
			writer.write(cucumberOpt);
			writer.write("\n");
			writer.write(cucumberApi);
			writer.write("\n");
			writer.write(impFile);
		/*	writer.write("\n");
			writer.write(impDriMan);
*/
			// writer.write("\n");
			// writer.write(impReporter);

			/*writer.write("\n");
			writer.write(impAfter);
*/
			writer.write("\n");
			writer.write(b);
			writer.write("\n");
			writer.write(c);
			writer.write("\n");
			writer.write(f);
			writer.write("\n");
			writer.write(g);
			writer.write("\n");
			writer.write(p);
			writer.write("\n");
			writer.write(t);
			writer.write("\n");
			writer.write(sourceCode);
			writer.write("\n");
			/*writer.write(sourceCode1);
			writer.write("\n");*/
			// writer.write(sourceCode2);
			writer.close();

			// compile the source file
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

			String[] options = new String[] { "-d", System.getProperty("user.dir") + "/target/test-classes" };

			Iterable<? extends JavaFileObject> compilationUnits = fileManager
					.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile));
			compiler.getTask(null, fileManager, null, Arrays.asList(options), null, compilationUnits).call();
			fileManager.close();
			Class<?> loadedClass = classLoader.loadClass("com.testrunner." + classname + "");
			System.out.println("Done.....");
		}
		System.setProperty("myname", "Rahul");

	}
}
