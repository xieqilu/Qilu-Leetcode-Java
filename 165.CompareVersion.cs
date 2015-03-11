Code Definition:
public class Solution {
    public int CompareVersion(string version1, string version2) {
        
    }
}


Driver Code:
class __Driver__ {
  static void Main(string[] args) {
  using (StreamWriter file = new StreamWriter("user.out")) {
    file.AutoFlush = true;
    string line;
    while ((line = Console.ReadLine()) != null) {
      string[] input = line.Split(new char[] { ' ' }, StringSplitOptions.None);
      string s1 = input[1];
      string s2 = input[3];
      file.WriteLine(__Serializer__.serialize(new Solution().CompareVersion(s1, s2)));
    }
  }
  }
}



Ac Solution Code:
public class Solution {
    public int CompareVersion(string version1, string version2) {
        string[] v1 = version1.Split('.');
        string[] v2 = version2.Split('.');
        int i=0;
        while(i<v1.Length||i<v2.Length){
            int num1 = i<v1.Length? int.Parse(v1[i]) : 0;
            int num2 = i<v2.Length? int.Parse(v2[i]) : 0;
            if(num1>num2) return 1;
            else if(num1<num2) return -1;
            i++;
        }
        return 0;
    }
}
