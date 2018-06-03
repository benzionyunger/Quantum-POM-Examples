<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Quantum POM Demo Suite" verbose="0" parallel="none">
    <listeners>
        <listener class-name="com.quantum.listerners.QuantumReportiumListener" />
    </listeners>

    <test name="POM Test" enabled="true">
        <parameter name="driver.capabilities.deviceName" value="{device name}"></parameter>
        <parameter name="env.resources" value="src/main/resources/common"></parameter>
        <classes>
            <class name="com.quantum.RentalPropertyManagerTest" />
        </classes>
    </test>
</suite>