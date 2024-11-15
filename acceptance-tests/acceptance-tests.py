import requests
import sys

BASE_URL = sys.argv[1]

def check_ok_status():
    print("\033[1;34;47m Running test for /ok endpoint\n")
    isStatusCodeMatched = False
    isResponseMessageMatched = False
    response = requests.get(f"{BASE_URL}/ok")
    if(response.status_code == 200):
        isStatusCodeMatched = True
        print("\033[1;32;47m Expected Status Code: 200, Received Status Code: ", response.status_code)
    else:
        print("\033[1;31;47m Expected Status Code: 200, Received Status Code: ", response.status_code)
    
    responseBody  = response.json()
    if(responseBody.get("message") == "OK"):
        isResponseMessageMatched = True
        print("\033[1;32;47m Expected Response message: 'OK', Received Response message: ", responseBody.get("message"))
    else:
        print("\033[1;31;47m Expected Response message: 'OK', Received Response message: ", responseBody.get("message"))
    return isStatusCodeMatched and isResponseMessageMatched
        

def check_no_content_status():
    print("\033[1;34;47m Running test for /no-content endpoint\n")
    isStatusCodeMatched = False
    isResponseMessageMatched = True
    response = requests.get(f"{BASE_URL}/no-content")
    if(response.status_code == 204):
        isStatusCodeMatched = True
        print("\033[1;32;47m Expected Status Code: 204, Received Status Code: ", response.status_code)
    else:
        print("\033[1;31;47m Expected Status Code: 204, Received Status Code: ", response.status_code)
    
    if(response.text != ""):
        print("\033[1;31;47m Expected empty response but received: ", response.text)
    return isStatusCodeMatched and isResponseMessageMatched

if __name__ == "__main__":
    receivedExpectedResponseForOk = check_ok_status()
    print("\n")
    receivedExpectedResponseForNoContent = check_no_content_status()
    print("\n")
    if(receivedExpectedResponseForOk and receivedExpectedResponseForNoContent):
        print("\033[1;32;47m Tests Passed")
        exit(0)
    else:
        print("\033[1;31;47m Tests Failed")
        exit(1)