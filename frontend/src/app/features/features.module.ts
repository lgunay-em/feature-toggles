import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FeaturesComponent } from './features.component';

import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';


import { FeaturesService } from './features.service';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FeatureFormComponent } from './feature-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { ArchiveComponent } from './archive.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
    { path: '', component: FeaturesComponent }
];

@NgModule({
  declarations: [
    FeaturesComponent,
    FeatureFormComponent,
    ArchiveComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatTableModule,
    MatButtonModule,
    MatPaginatorModule,
    MatMenuModule,
    MatIconModule,
    MatDialogModule,
    MatInputModule,
    MatRadioModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
      FeaturesService
  ],
  exports: [RouterModule],
  bootstrap: [],
  entryComponents: [
    FeatureFormComponent,
    ArchiveComponent
  ]
})
export class FeaturesModule { }
