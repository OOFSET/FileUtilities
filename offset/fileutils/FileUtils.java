package offset.fileutils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@SuppressWarnings("unused")
public class FileUtils {

	
	
	
	public void createFile(File f) {
	
			f.mkdir();
		
	}
	public boolean checkFileExistance(File f) {
		if(f.exists()) {
			return true;
		}
		return false;
	}
	public boolean checkIfDirectory(File f) {
		if(f.exists() && f.isDirectory()) {
			return true;
		}
		return false;
		
}
	public boolean checkIfFileContainsContent(File f) {
	double fileSize = f.length();
	
	if(fileSize != 0) {
		return true;
	}
	return false;
	}
	public void deleteFile(File f) {
		f.delete();
	}
	public long rename(File f) {
		return f.getTotalSpace();
	}
	@SuppressWarnings("deprecation")
	public void setLastModified(File fileToStore,long lastUsed) {
		fileToStore.setLastModified(lastUsed);
	
	}
	public void downloadFileFromURL(String urlLink, File fileDestination) {    
        try {
            URL website = new URL(urlLink);
            ReadableByteChannel readableBytes;
            readableBytes = Channels.newChannel(website.openStream());
            FileOutputStream fileOutput = new FileOutputStream(fileDestination);
            fileOutput.getChannel().transferFrom(readableBytes, 0, Long.MAX_VALUE);
            fileOutput.close();
            readableBytes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
public long getLastModified(File f) {
	return f.lastModified();
	
}
	public String getPath(File f) {
		return f.getAbsolutePath();
	}

}
