# PowerShell script to upload a file using cURL

# Path to the file you want to upload
$filePath = "C:/Users/WDAGUtilityAccount/Desktop/t.txt"

# Webhook URL
$webhookUrl = "https://discord.com/api/webhooks/1311053691310178366/YbI5wprIFytQEbqru6RDLN6fta08vELFToRY35qcd177flpaqA2FjHpMFDeJt2elbJkN"

# Ensure the file exists before proceeding
if (Test-Path $filePath) {
    # Execute the curl command to upload the file
    $curlCommand = "curl -F `""file=@$filePath`"" `"$webhookUrl`""
    iex $curlCommand
}
