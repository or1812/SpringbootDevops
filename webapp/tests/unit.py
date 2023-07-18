import json
import unittest
import requests
from datetime import datetime


creation_route_response = requests.get("http://127.0.0.1:8080/newlog")
response = requests.get("http://127.0.0.1:8080/logs")
json_data = response.json()
current_datetime = datetime.now()
formatted_datetime = current_datetime.strftime('%Y-%m-%d %H:%M')


class MyTestCase(unittest.TestCase):
    # Check status code (200 - OK)
    def test_is_application_up(self):
        self.assertEqual(response.status_code, 200)
        self.assertEqual(creation_route_response.status_code, 200)
        print("200 status code - OK")

    # Check response format (JSON)
    def test_response_format(self):
        try:
            self.assertIsInstance(json_data, list)  # Assuming the response is a list of objects
            print("Response format is a list - OK")
            for item in json_data:
                self.assertIsInstance(item, dict)  # Assuming each item is a dictionary
            print("Response content is a dictionary - OK")
        except json.JSONDecodeError:
            self.fail("Failed to decode JSON response")

    # Check if the newly added log (by requests.get) equals to the logs from database.
    def test_log_content(self):
        try:
            passed_test = False
            for item in json_data:
                if item["message"] == f"Request made on { formatted_datetime } to route: /logs":
                    passed_test = True
                    
            if passed_test is False:
                raise Exception("The expected log does not match the current log in the database.")
            else:
                print("Expected log content - OK")
        except json.JSONDecodeError:
            self.fail("Failed to decode JSON response")

    def test_log_creation_route(self):
        try:
            passed_test = False
            for item in json_data:
                if item["message"] == f"Request made on {formatted_datetime} to route: /newlog":
                    passed_test = True

            if passed_test is False:
                raise Exception("The log haven't created to the database.")
            else:
                print("Expected new log creation - OK")
        except json.JSONDecodeError:
            self.fail("Failed to decode JSON response")


if __name__ == '__main__':

    unittest.main()
