class Solution {
    public boolean isIsomorphic(String s, String t) {
      if(s.length() != t.length())
          return false;
        
      Map<Character, Character> map = new HashMap<>();
        
      for(int i =0; i<s.length(); i++){
        
      char original = s.charAt(i);
      char replaced = t.charAt(i);
    
      if(!map.containsKey(original)){
          if(!map.containsValue(replaced)){
           map.put(original, replaced);
          }
          else{
              return false;
              }
      }
      else{ 
          char mappedChar= map.get(original);
          if(mappedChar != replaced)
              return false;
      }
      
          
      }
       return true; 
      }  
    }