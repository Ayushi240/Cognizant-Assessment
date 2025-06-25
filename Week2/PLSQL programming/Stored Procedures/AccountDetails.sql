-- Scenario 1 — Process Monthly Interest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT ACCOUNT_ID, BALANCE FROM SAVINGS_ACCOUNTS) LOOP
    UPDATE SAVINGS_ACCOUNTS
    SET BALANCE = BALANCE + (BALANCE * 0.01)
    WHERE ACCOUNT_ID = acc.ACCOUNT_ID;

    DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || acc.ACCOUNT_ID);
  END LOOP;

  COMMIT;
END;
/

--Scenario 2 — Bonus for Employees by Department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept_id IN NUMBER,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  FOR emp IN (SELECT EMP_ID FROM EMPLOYEES WHERE DEPARTMENT_ID = p_dept_id) LOOP
    UPDATE EMPLOYEES
    SET SALARY = SALARY + (SALARY * p_bonus_percent / 100)
    WHERE EMP_ID = emp.EMP_ID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp.EMP_ID);
  END LOOP;

  COMMIT;
END;
/

--Scenario 3 — Transfer Funds Between Accounts

CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) IS
  v_balance NUMBER;
BEGIN
  -- Get balance from source account using ACCOUNT_NO
  SELECT BALANCE INTO v_balance FROM ACCOUNTS WHERE ACCOUNT_NO = p_from_account;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
  END IF;

  -- Deduct from source
  UPDATE ACCOUNTS
  SET BALANCE = BALANCE - p_amount
  WHERE ACCOUNT_NO = p_from_account;

  -- Add to destination
  UPDATE ACCOUNTS
  SET BALANCE = BALANCE + p_amount
  WHERE ACCOUNT_NO = p_to_account;

  DBMS_OUTPUT.PUT_LINE('Transferred ₹' || p_amount || ' from account ' || p_from_account || ' to account ' || p_to_account);

  COMMIT;
END;
/
SHOW ERRORS PROCEDURE TransferFunds;


BEGIN
  TransferFunds(1111, 2222, 5000);
END;
