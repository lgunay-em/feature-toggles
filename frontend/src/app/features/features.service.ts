import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { environment } from '../../environments/environment';
import { data } from './features.mock';

@Injectable()
export class FeaturesService {

    constructor(
        protected http: HttpClient
    ) {}

    createNew(feature) {
        return this.http.post('/api/v1/features', feature);
    }

    update(feature) {
        return this.http.put('api/v1/features/' + feature.id, feature);
    }

    getAll(page = 0): Observable<any> {
        return environment.production ? this.http.get('/api/v1/features?page=' + page)  : of(data);
    }

}
