SET SERVEROUTPUT ON;

-- Scenario 1: Apply Discount

BEGIN
  FOR c IN (SELECT CUSTOMER_ID FROM CUSTOMERS WHERE AGE > 60) LOOP
    UPDATE LOANS 
    SET INTEREST_RATE = INTEREST_RATE - 1 
    WHERE CUSTOMER_ID = c.CUSTOMER_ID;
    DBMS_OUTPUT.PUT_LINE('Discount applied to customer ID: ' || c.CUSTOMER_ID);
  END LOOP;

  COMMIT; 
END;
/

-- Scenario 2: Mark VIP Customers

BEGIN
  FOR c IN (SELECT CUSTOMER_ID FROM CUSTOMERS WHERE BALANCE > 10000) LOOP
    UPDATE CUSTOMERS
    SET ISVIP = 'TRUE'
    WHERE CUSTOMER_ID = c.CUSTOMER_ID;
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || c.CUSTOMER_ID || ' promoted to VIP.');
  END LOOP;

  COMMIT; 
END;
/

-- Scenario 3: Loan Due Reminders

BEGIN
  FOR rec IN (
    SELECT c.NAME, l.DUE_DATE
    FROM LOANS l
    JOIN CUSTOMERS c ON l.CUSTOMER_ID = c.CUSTOMER_ID
    WHERE l.DUE_DATE <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.NAME || ' has a loan due on ' || TO_CHAR(rec.DUE_DATE, 'DD-MON-YYYY'));
  END LOOP;
END;
/