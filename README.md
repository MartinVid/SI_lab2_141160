Група на код: 1

CFG:
Line | Code
 1. if (user!=null)
 2. if (user.getUsername()!=null
 3. user.getEmail()!=null
 4. !allUsers.contains(user.getUsername())
 5. boolean atChar = false, dotChar = false;
 6. for (int i=0;i<user.getEmail().length();i++) {
 7. if (user.getEmail().charAt(i)=='@')
 8. atChar = true;
 9. if (atChar
 10. user.getEmail().charAt(i)=='.'
 11. dotChar = true;
 12. }
 13. if (atChar
 14. && dotChar) {
 15. return true;
 16. return false;
 
 ===========================================================================
 
 TEST CASES:
 
 TC1	    User(Username1, Password1, email@mail.com)  - Ги исполнува сите услови
 
 TC2	    User(Username2, Password2, email@mail)      - Не содржи "."
 
 TC3	    User(Username3, Password3, email.com)       - Не содржи "@"
 
 TC4	    User(Username4, Password4, email@mail.com)  - Се содржи во allUsers
 
 TC5	    null                                        - User = null
 
 TC6	    User(null, Password, email@mail)            - Username = null
 
 TC7	    User(Username, Password2, null)             - Email = null

 ===========================================================================

 Every Statement критериумот:
 
 Node	Source Line	                                        TC1     TC2     TC3     TC4
 
 A	    if (user!=null)                                     *       *       *       *
 
 B	    if (user.getUsername()!=null ...	                   *	      *	      *	      *
 
 C	    boolean atChar = false, dotChar = false;	           *	      *	      *	
 
 D	    for (int i=0;i<user.getEmail().length();i++)	       *	     *	     *	
 
 E	    if (user.getEmail().charAt(i)=='@')	                *	     *	     *	
 
 F	    atChar = true;	                                     *	     *		
 
 G	    if (atChar && user.getEmail().charAt(i)=='.')	      *	     *	     *	
 
 H	    dotChar = true;	                                    *			
 
 I	    }	                                                  *	     *	     *	
 
 J	    if (atChar && dotChar)	                             *	     *	     *	
 
 K	    return true;	                                       *			
 
 L	    return false;		                                     *	     *     	 *

(view in raw for table preview)

 ===========================================================================
 
Multiple condtition критериумот:

if (user!=null)

Combination	    Possible Test Case     Branch

    T	          user = null	            A-K
    
    F	            TC1	                  A-B
    
--------------------------------------------------------	

if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))

Combination	    Possible Test Case          Branch

    TTT	                TC1	                  B-C
    
    TTF	                TC4	                  B-K
    
    TFX	                TC6         	         B-K
    
    FXX	                TC7	                  B-K
    
--------------------------------------------------------

if (user.getEmail().charAt(i)=='@')

Combination	    Possible Test Case          Branch

    T	                TC1	                  E-F
    
    F	                TC3                  E-G
    
--------------------------------------------------------

if (atChar && user.getEmail().charAt(i)=='.')

Combination	    Possible Test Case          Branch

    TT	                TC1	                  G-H
    
    TF	                TC2                  G-I
    
    FX	                TC3                  G-I
    
--------------------------------------------------------

if (atChar && dotChar)

Combination	    Possible Test Case          Branch

TT	                    TC1	                  J-K

TF	                    TC2	                  J-L

FX	                    TC3                  J-L

--------------------------------------------------------

Цикломатската комплексност на функцијата:

1. Број на региони = 10
Број на рабови = 24
Број на јазли = 16
2. V(G) = E - N + 2 = 24 - 16 + 2 = 10
Број на предикатни јазли = 9
3. V(G) = 9 + 1 = 10

Со ова добиваме дека имаме 10 можни патеки кои се покриени со тестови
