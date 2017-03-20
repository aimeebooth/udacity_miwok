package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

  // m indicates private member variables
  private String mDefaultTranslation;
  private String mMiwokTranslation;
  private int mAudioResourceId;
  private int mImageResourceId = NO_IMAGE_PROVIDED;
  private static final int NO_IMAGE_PROVIDED = -1;

  /**
   * Create a new Word object.
   *
   * @param defaultTranslation is the word in a language that the user is already familiar with (such as English)
   *
   * @param miwokTranslation is the word in the Miwok language
   *
   * @param audioResourceId is the resource ID for the audio file associated with this word
   */
  public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
    mDefaultTranslation = defaultTranslation;
    mMiwokTranslation = miwokTranslation;
    mAudioResourceId = audioResourceId;
  }

  /**
   * Create a new Word object.
   *
   * @param defaultTranslation is the word in a language that the user is already familiar with (such as English)
   *
   * @param miwokTranslation is the word in the Miwok language
   *
   * @param imageResourceId is the image associated with the translation
   *
   * @param audioResourceId is the resource ID for the audio file associated with this word
   */
  public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
    mDefaultTranslation = defaultTranslation;
    mMiwokTranslation = miwokTranslation;
    mImageResourceId = imageResourceId ;
    mAudioResourceId = audioResourceId;
  }

  public String getDefaultTranslation() {
    return mDefaultTranslation;
  }

  public String getMiwokTranslation() {
    return mMiwokTranslation;
  }

  public int getImageResourceId() {
    return mImageResourceId;
  }

  /**
   *
   * @return whether or not there is an image for this word.
   *
   */
  public boolean hasImage() {
    return mImageResourceId != NO_IMAGE_PROVIDED;
  }

  /**
   * Return the audio resource ID of the word.
   */
  public int getAudioResourceId() {
    return mAudioResourceId;
  }
}
