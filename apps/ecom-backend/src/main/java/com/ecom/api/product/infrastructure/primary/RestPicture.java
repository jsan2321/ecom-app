package com.ecom.api.product.infrastructure.primary;


import com.ecom.api.product.domain.aggregate.Picture;
import com.ecom.api.product.domain.aggregate.PictureBuilder;
import com.ecom.api.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record RestPicture(byte[] file,
                          String mimeType) {

  public RestPicture {
    Assert.notNull("file", file);
    Assert.notNull("mimeType", mimeType);
  }

  public static Picture toDomain(RestPicture restPicture) {
    return PictureBuilder
             .picture()
             .file(restPicture.file())
             .mimeType(restPicture.mimeType())
             .build();
  }

  public static RestPicture fromDomain(Picture picture) {
    return RestPictureBuilder.restPicture()
                             .file(picture.file())
                             .mimeType(picture.mimeType())
                             .build();
  }

  public static List<Picture> toDomain(List<RestPicture> restPictures) {
    return restPictures.stream().map(RestPicture::toDomain).collect(Collectors.toList());
  }

  public static List<RestPicture> fromDomain(List<Picture> pictures) {
    return pictures.stream().map(RestPicture::fromDomain).collect(Collectors.toList());
  }
}
