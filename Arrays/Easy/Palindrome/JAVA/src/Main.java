import java.io.*;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;



class Config{
  private String testcasesFile;
  private String JavaResultFile;
  
  String getTestCaseFile(){
    return this.testcasesFile;
  }

  String getOutputFile(){
    return this.JavaResultFile;
  }

  public void setTestCaseFile(String testcasesFile) {
    this.testcasesFile = testcasesFile;
  }

  public void setJavaResultFile(String javaResultFile) {
    JavaResultFile = javaResultFile;
  }

}


// Change This according to the Testcases.json file
class Testcase {
  private String input;
  private boolean output;
  private boolean result;

  public String getInput() {
    return input;
  }
  public boolean getOutput(){
    return output;
  }
  public boolean getResult(){
    return result;
  }
  public void setResult(boolean result) {
    this.result = result;
  }
  public void setInput(String input) {
    this.input = input;
  }
  public void setOutput(boolean output) {
    this.output = output;
  }

  public String toString(){
    return "Input: " + input + " Output: " + output;
  }

}



class  Util{
  Testcase[] testcases;
  Config config;
  Gson gson;
  Util(){
    this.gson = new Gson();
    this.config = readConfig();
    this.testcases = readTestcases();
  }

  private Config readConfig(){
    Config config=null;
    try {
      
      File file = new File("../../conf/config.json");
      JsonReader r = new JsonReader(new FileReader(file.getAbsolutePath()));
      config = gson.fromJson(r,Config.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return config;
  }

  private Testcase[] readTestcases(){
    Testcase[] testcases=null;
    try {
      File file = new File("../../"+config.getTestCaseFile());
      JsonReader reader = new JsonReader(new FileReader(file.getAbsolutePath()));
      testcases = gson.fromJson(reader,Testcase[].class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return testcases;
  }

  public void writeTestCases(){
    try {
      File file = new File("../../"+config.getOutputFile());
      String json = gson.toJson(testcases);
      FileWriter writer = new FileWriter(file.getAbsolutePath());
      writer.write(json);
      writer.close();
      return;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


public class Main{
  public static void main(String[] args){
    Util util = new Util();
    PalindromeTest tester = new PalindromeTest();
    boolean failed = false;

    for(Testcase testcase:util.testcases){
      boolean result = tester.test(testcase.getInput(),testcase.getOutput());
      testcase.setResult(result);
      if(!result) failed = true;
    }

    util.writeTestCases();
    if (failed) 
      System.exit(1);
    
    System.out.println("Passed");
    System.exit(0);
  }
}