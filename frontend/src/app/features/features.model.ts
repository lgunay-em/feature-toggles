

export class Feature {
    id: number;
    displayName?: string;
    technicalName: string;
    expiresOn?: Date;
    description?: string;
    inverted: boolean;
    customerIds: string[];
}