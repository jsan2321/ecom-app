export type ProductSizes = 'XS' | 'S' | 'M' | 'L' | 'XL' | 'XXL';
export const sizes: ProductSizes[] = ['XS', 'S', 'M', 'L', 'XL', 'XXL'];

export interface ProductCategory {
  publicId?: string;
  name?: string;
}

export interface ProductPicture {
  file: File;
  mimeType: string;
}

export interface BaseProduct {
  brand: string;
  color: string;
  description: string;
  name: string;
  price: number;
  size: ProductSizes;
  category: ProductCategory;
  featured: boolean;
  pictures: ProductPicture[];
  nbInStock: number;
}

export interface Product extends BaseProduct {
  publicId: string;
}
