# JMeter Test Plan - Problem 8

## Overview
This document provides instructions for creating a JMeter test plan to test the MakeMyTrip website using Thread Groups, Assertions, and Listeners.

## Prerequisites
- Apache JMeter 5.x or higher installed
- Target URL: https://www.makemytrip.com/

## Test Plan Configuration

### 1. Create Test Plan
1. Open JMeter
2. Right-click on "Test Plan" in the left pane
3. Rename it to "MakeMyTrip Performance Test"

### 2. Add Thread Group
1. Right-click on Test Plan
2. Add → Threads (Users) → Thread Group
3. Configure Thread Group properties:
   - **Name**: MakeMyTrip Users
   - **Number of Threads (users)**: 10
   - **Ramp-up period (seconds)**: 2
   - **Loop Count**: 1
   - **Action to be taken after a Sampler error**: Continue

### 3. Add HTTP Request Sampler
1. Right-click on Thread Group
2. Add → Sampler → HTTP Request
3. Configure HTTP Request:
   - **Name**: MakeMyTrip Homepage Request
   - **Protocol**: https
   - **Server Name or IP**: www.makemytrip.com
   - **Port Number**: (leave blank for default)
   - **Method**: GET
   - **Path**: /

### 4. Add Response Assertions
1. Right-click on HTTP Request
2. Add → Assertions → Response Assertion
3. Configure Response Assertion:
   - **Name**: Status Code Assertion
   - **Apply to**: Main sample only
   - **Response Field to Test**: Response Code
   - **Pattern Matching Rules**: Equals
   - **Patterns to Test**: Add pattern "200"

4. Add another Response Assertion for content:
   - **Name**: Content Assertion
   - **Apply to**: Main sample only
   - **Response Field to Test**: Text Response
   - **Pattern Matching Rules**: Contains
   - **Patterns to Test**: Add pattern "MakeMyTrip"

### 5. Add Duration Assertion
1. Right-click on HTTP Request
2. Add → Assertions → Duration Assertion
3. Configure:
   - **Name**: Response Time Assertion
   - **Duration in milliseconds**: 5000

### 6. Add Listeners

#### View Results Tree
1. Right-click on Thread Group
2. Add → Listener → View Results Tree
3. This listener shows detailed results for each request

#### Assertion Results
1. Right-click on Thread Group
2. Add → Listener → Assertion Results
3. This listener shows the results of all assertions

#### Summary Report
1. Right-click on Thread Group
2. Add → Listener → Summary Report
3. Provides statistical summary of the test execution

#### Graph Results
1. Right-click on Thread Group
2. Add → Listener → Graph Results
3. Provides graphical representation of performance

### 7. Run the Test
1. Click the green "Start" button (Play icon) in the toolbar
2. Wait for the test to complete
3. Review results in each listener

## Test Plan Structure

```
Test Plan: MakeMyTrip Performance Test
└── Thread Group: MakeMyTrip Users
    ├── HTTP Request: MakeMyTrip Homepage Request
    │   ├── Response Assertion: Status Code Assertion
    │   ├── Response Assertion: Content Assertion
    │   └── Duration Assertion: Response Time Assertion
    ├── Listener: View Results Tree
    ├── Listener: Assertion Results
    ├── Listener: Summary Report
    └── Listener: Graph Results
```

## Validation Points

### Assertions Validate:
1. **HTTP Status Code**: Verify response code is 200 (OK)
2. **Response Content**: Verify response contains "MakeMyTrip" text
3. **Response Time**: Verify response time is under 5000ms

### Listeners Show:
1. **View Results Tree**: Individual request/response details
2. **Assertion Results**: Pass/Fail status of all assertions
3. **Summary Report**: Average response time, throughput, error rate
4. **Graph Results**: Visual representation of response times

## Expected Results

### Positive Scenarios:
- All assertions should pass
- HTTP Status Code: 200
- Response should contain "MakeMyTrip"
- Response time should be < 5000ms

### Metrics to Monitor:
- **Average Response Time**: Should be reasonable (< 3000ms)
- **Throughput**: Requests per second
- **Error Rate**: Should be 0% or very low
- **Standard Deviation**: Lower is better (consistency)

## Saving the Test Plan

1. File → Save Test Plan As
2. Save as: `MakeMyTrip_TestPlan.jmx`
3. Location: `jmeter/` directory

## Running from Command Line

```bash
jmeter -n -t MakeMyTrip_TestPlan.jmx -l results.jtl -e -o report
```

Parameters:
- `-n`: Non-GUI mode
- `-t`: Test plan file
- `-l`: Log file
- `-e`: Generate report dashboard
- `-o`: Output folder for report

## Advanced Configuration (Optional)

### Add HTTP Header Manager
1. Right-click on HTTP Request
2. Add → Config Element → HTTP Header Manager
3. Add headers:
   - User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)
   - Accept: text/html,application/xhtml+xml

### Add Response Time Graph
1. Right-click on Thread Group
2. Add → Listener → Response Time Graph
3. Configure intervals as needed

### Add CSV Data Set Config (for parameterization)
1. Right-click on Thread Group
2. Add → Config Element → CSV Data Set Config
3. Configure to read test data from CSV file

## Troubleshooting

### Issue: Connection Timeout
- Increase timeout in HTTP Request: Advanced tab → Timeouts
- Check network connectivity

### Issue: SSL Handshake Error
- Add SSL Manager configuration
- Import necessary certificates

### Issue: Rate Limiting
- Reduce number of threads
- Increase ramp-up period

## Notes

- The website may have rate limiting or CAPTCHA protection
- Adjust thread count based on testing requirements
- Always test in lower environments before production
- Ensure you have permission to perform load testing on the target

## References

- Apache JMeter Documentation: https://jmeter.apache.org/usermanual/
- JMeter Best Practices: https://jmeter.apache.org/usermanual/best-practices.html
