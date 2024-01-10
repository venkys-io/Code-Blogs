import os
import json
import sys
from PalindromeTest import Test

class Util:

  def __init__(self):
    self.config = self.readConfig()
    self.testcases = self.readTestcases()

  def readConfig(self):
    with open(os.path.join(os.path.dirname(__file__),"../../","conf/config.json"),'r') as configFile:
      configJson =  json.load(configFile)
    return configJson

  def readTestcases(self):
    testcaseFile = self.config.get('testcasesFile')
    with open(os.path.join(os.path.dirname(__file__),"../../",testcaseFile),'r') as testcases:
      testcasesJson = json.load(testcases)
    return testcasesJson

  def writeTestCases(self):
    with open(os.path.join(os.path.dirname(__file__),"../../",self.config.get('PythonResultFile')),'w') as testcases:
      json.dump(self.testcases,testcases,indent=4)



def main():

  obj = Util()
  testObj = Test()
  failed = False
  
  for testcase in obj.testcases:
    result = testObj.test(testcase.get("input"),testcase.get("output"))
    testcase["result"] = result
    if not result:
      failed = True
  obj.writeTestCases()
  if failed:
    sys.exit(1)


if __name__=="__main__":
  main()