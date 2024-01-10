
#include "../include/json.hpp"
#include "../include/PalindromeTest.hpp"
#include <filesystem>
#include <fstream>
#include <iostream>
#include <vector>
#include <string>
using json = nlohmann::json;

class Config{
  public:
    std::string testcasesFile;
    std::string CppResultFile;
};


// Change this According to the testcases.json file
class TestCase{
  public:
    std::string input;
    bool output;
    bool result;

    void to_json(json& j) {
        j = json{{"input", input}, {"output", output}, {"result", result}};
    }
};


json serialize(std::vector<TestCase> testcases){
  json outputJson = json::array();
  for(TestCase testcase:testcases){
    json j;
    testcase.to_json(j);
    outputJson.push_back(j);
  }
  return outputJson;
}



class Util{
public:

  std::vector<TestCase> testcases;
  Config config;
    Util(){
      config = readConfig();
      testcases = readTestcases();
    }
    Config readConfig(){
      std::ifstream configFile;
      std::filesystem::path p = "../../conf/config.json";
      configFile.open(std::filesystem::absolute(p));
      json configJson;
      configFile >> configJson;
      configFile.close();
      Config config;
      config.testcasesFile = configJson["testcasesFile"];
      config.CppResultFile = configJson["CppResultFile"];
      return config;
    }
    std::vector<TestCase> readTestcases(){
      std::ifstream testcaseFile;
      std::filesystem::path p = "../../"+config.testcasesFile;
      json j;
      testcaseFile.open(std::filesystem::absolute(p));
      testcaseFile >> j;
      std::vector<TestCase> testcases;
      for(int i=0;i<j.size();i++){
        TestCase testcase;


        // Change the input type according to the Testcases class
        testcase.input = j[i]["input"].get<std::string>();
        testcase.output = j[i]["output"].get<bool>();
        testcases.push_back(testcase);
      }
      return testcases;
    }

    void writeResult(){
      std::ofstream resultFile;
      std::filesystem::path p = "../../"+config.CppResultFile;
      resultFile.open(std::filesystem::absolute(p));
      json j = serialize(testcases);
      resultFile << j.dump(2);
      resultFile.close();
    }
};


int main(){
  Util util;
  PalindromeTest tester;
  std::vector<TestCase>& testcases = util.testcases;
  bool failed = false;

  for(TestCase testcase:testcases){
      int result = tester.test(testcase.input,testcase.output);
      testcase.result = result;
      if(!result){
          failed = true;
      }
  }
  util.writeResult();
  if(failed) return 1;
  std::cout<< "Passed" << std::endl;
  return 0;
}