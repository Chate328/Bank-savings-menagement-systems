package ���д���������;
	import java.io.File;
public class DeleteFileUtil {
/*  
ɾ���ļ��������ǵ����ļ����ļ���
@param fileName
��ɾ�����ļ���
 @return �ļ�ɾ���ɹ�����true,���򷵻�false
*/

	    public static boolean delete(String fileName) {

	        File file = new File(fileName);

	        if (!file.exists()) {

	            System.out.println("ɾ���ļ�ʧ�ܣ�" + fileName + "�ļ�������");

	            return false;

	        } else {

	            if (file.isFile()) {

	  

	                return deleteFile(fileName);

	            } else {

	                return false;

	            }

	        }

	    }

	  

	    /**

	     * ɾ�������ļ�

	     * 

	     * @param fileName

	     *            ��ɾ���ļ����ļ���

	     * @return �����ļ�ɾ���ɹ�����true,���򷵻�false

	     */

	    public static boolean deleteFile(String fileName) {

	        File file = new File(fileName);

	        if (file.isFile() && file.exists()) {

	            file.delete();

	            System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");

	            return true;

	        } else {

	            System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ� �ļ�������!");

	            return false;

	        }

	    }

	  

	   
	  


	  


	}

